package com.wordz.domain;

import javax.naming.InvalidNameException;

public class Username {
    private final String name;
    public Username(String username) throws InvalidNameException{
        //si el nombre de usuario es menor a 3 caracteres tira una excepcion
        if(username.length()<4){
            throw new InvalidNameException("Username must be at least 4 characters long");
        }
        name = username;
    }

    public String asLowerCase() {
        var result = new StringBuilder();
        char aux;
        //poniendo el i en 0, nos aseguramos que tome desde el inicio de la cadena
        for (int i=0; i < name.length(); i++) {
            char current = name.charAt(i);
            if (current >= 'A' && current <= 'Z') {
                //ahora si se agregara como char y no como numero
                aux = (char) (current + 'a' - 'A');
                result.append(aux);
            } else {
                result.append( current );
            }
        }
        //esto genera el error al convertir el numero en string
        return result.toString() ;
    }
}