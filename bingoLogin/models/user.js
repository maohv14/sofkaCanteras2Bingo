const mongoose = require('mongoose');
const Schema = mongoose.Schema;
const mongooseSoftDelete = require('mongoose-delete');
const bcrypt = require('bcrypt');

const saltRounds = 10;
/**
 * Modelo que permite definir el schema con los parametros a registrar, tales como nombre, correo y contraseña
 * @autor Mauro Villada, mauro1040@gmail.com
 * @version 1.0.0, 2022-03-13
 *
 */

/**
 * Función para validar si se ha ingregado un email valido
 * @param email
 * @returns {boolean}
 */
const validateEmail = (email) => {
    var regexp = /[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/;
    return regexp.test(email);
};


const userSchema = new Schema({
    name: {
        type: String,
        trim: true,
        required: [true, 'El nombre es requerido']
    },

    email: {
        type: String,
        lowercase: true,
        trim: true,
        required: [true, 'El correo es requerido'],
        unique: true,
        validate: {
            validator: validateEmail,
            message: 'Por favor digite un correo válido'
        }
    },

    password: {
        type: String,
        lowercase: true,
        trim: true,
        required: [true, 'El password es requerido'],

    }


});

/**
 * Función para encriptar la contraseña
 */
userSchema.pre('save', function (next){
    if(this.isNew || this.isModified('password')){
        const document = this;

        bcrypt.hash(document.password, saltRounds,(err, hashedPassword)=>{
            if(err){
                next(err);
            }else{
                document.password = hashedPassword;
                next();
            }
        });
    }else{
        next();
    }
})
/**
 * Función para comparar y determinar si el password es correcto
 * @param password
 * @param callback
 */
userSchema.methods.isCorrectPassword = function (password, callback){
    bcrypt.compare(password, this.password, function (err, same){
        if(err){
            callback(err);
        }else{
            callback(err, same);
        }
    });
}
userSchema.plugin(mongooseSoftDelete);
module.exports = User = mongoose.model('User', userSchema);