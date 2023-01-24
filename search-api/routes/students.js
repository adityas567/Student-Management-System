const express=require('express');

const router=express.Router();

const control=require('../src/functions');

const pattern= /[^a-zA-Z]/g;

const pool=require('../src/db')



router.get('/',control.getStudents)

router.get('/:key',(req,res)=>
{
    if(pattern.test(req.params.key)==true)
    {
        pool.query("SELECT student_id,full_name,age,phno,email,address,course_id from student_data WHERE student_id= $1",[req.params.key],(error,results)=>
    {
        if(error)
        {
            throw error
        }
        res.status(200).json(results.rows);
    });
    }
    else
    {
        pool.query("SELECT student_id,full_name,age,phno,email,address,course_id from student_data WHERE full_name like $1",[`%${req.params.key}%`],(error,results)=>
    {
        if(error)
        {
            throw error
        }
        res.status(200).json(results.rows);
    });
    }
})


router.get('/getByName/:key',control.getStudentsByName)

module.exports=router



