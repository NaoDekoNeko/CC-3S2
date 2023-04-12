package com.wordz.domain;

public class Score {
    private final String correct;
    private Letter resultado = Letter.INCORRECT;
    private int position;

    public Score(String correct) {
        this.correct = correct;
    }

    public Letter letter(int position) {
        return resultado;
    }

    public void assess(String attempt) {
        if (isCorrectLetter(attempt)) {
            resultado = Letter.CORRECT;
        }
    }
    //esto ayuda al codigo de llamada, es una mejor forma de comentar
    //desde el nombre de la funcion nos especifica su responsabilidad
    private boolean isCorrectLetter(String attempt){
        return correct.charAt(position) == attempt.
                charAt(position);
    }
}
