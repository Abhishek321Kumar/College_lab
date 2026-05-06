
const mongoose = require('mongoose')

const {title} = require('node:process')


const ticketSchema =  new mongoose.Schema({
    title: {type:String,require:true},
    description:{type:String},
    status:{type:String, default:'Open'},
    createdAt:{type:Date, default:Date.now}

});

module.exports = mongoose.model('Ticket',ticketSchema)



