const express = require('express');
const Ticket = require('../models/Ticket');
const router = express.Router();

//Create ticket
router.post('/',async(req,res)=>{
    try{
        const ticket = new Ticket(req.body);
        await ticket.save();
        res.status(201).json(ticket);
    }catch(err){
        res.status(400).json({err:err.message});
    }
});

module.exports = router;