const express = require('express');
const path = require('path');
const cookieParser = require('cookie-parser');
const bodyParser = require('body-parser');
const logger = require('morgan');
const mongoose = require("mongoose");
const {urlencoded} = require("express");
const bcrypt = require('bcrypt');
const User = require('./models/user');
const app = express();

/**
 * Esta aplicación permite la importación de las funciones requeridas para trabajar con bases de dados no SQL como
 * mongoose con express.
 * @author Mauro Villada, mauro1040@gmail.com
 * @version 1.0.0, 2022-03-13
 */

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: false}));

/**
 * Conexión con la base de datos en momgoDB
 * @type {string}
 */
const mongodb = 'mongodb://localhost/bingoLogingDb';
mongoose.connect(mongodb, { useNewUrlParser: true, useUnifiedTopology: true })
    .then(() => console.log('MongoDB connected'))
    .catch(err => console.log(err));

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

/**
 * Consumo de API por medio del POST para registrar usuarios
 */

app.post('/register', (req, res)=>{
    //const {name, email, password} =req.body;

    const user = new User({
        name: req.body.name,
        email: req.body.email,
        password: req.body.password
    });

    user.save(err =>{
        if(err){
            res.status(500).send('ERROR AL REGISTRAR USUARIO');
        }else{
            res.status(200).send('USUARIO REGISTRADO');
        }
    });

});

/**
 * Consumo de API por medio del POST para realizar login
 */
app.post('/login', (req, res)=>{
    const {email, password} = req.body;
    console.log(email);
    console.log(password);


    User.findOne({email}, (err, user)=>{
        if(err){
            res.status(500).send('ERROR AL AUTENTICAR AL USUARIO');
        }else if(!user){
            res.status(500).send('EL USUARIO NO EXISTE');
        }else{
            user.isCorrectPassword(password, (err, result)=>{
                if(err){
                    res.status(500).send('ERROR AL AUTENTICAR');
                }else if(result){
                    res.status(200).send('USUARIO AUTENTICADO CORRECTAMENTE');
                }else{
                    res.status(500).send('USUARIO Y/O CONTASEÑA INCORRECTOS');
                }
            });
        }
    });

});


module.exports = app;
