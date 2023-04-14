# Sprint 1

## 1. Historias de usuarios

<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Nombre de la historia de usuario</th>
            <th>Descripción de historia de usuario</th>
            <th>Prioridad</th>
            <th>Esfuerzo estimado (horas)</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td align="center">1</td>
            <td align="center">Escoge el tamaño del tablero</td>
            <td align="center"><b>Como </b>jugador <b>Quiero </b>ajustar el tamaño del tablero<b>  Para </b>ajustarlo a mi preferencia de juego</td>
            <td align="center">BAJA</td>
            <td align="center">3</td>
        </tr>
        <tr>
            <td align="center"> 2</td>
            <td align="center">Elige el modo de juego de un tablero elegido</td>
            <td align="center"><b>Como </b>jugador<b> Quiero </b>ajustar el modo de juego del tablero<b> Para </b>tener más opciones de juego </td>
            <td align="center">BAJA</td>
            <td align="center">1</td>
        </tr>
        <tr>
            <td align="center">3</td>
            <td align="center">Comienza un nuevo juego del tamaño de tablero y del modo de juego elegidos </td>
            <td align="center"><b>Como </b>jugador<b> Quiero </b>comenzar un nuevo juego con mis ajustes seleccionados<b> Para </b>sentir que tengo más posibilidades de tener una partida acorde a mi nivel </td>
            <td align="center">MEDIA</td>
            <td align="center">2</td>
        </tr>
        <tr>
            <td align="center">4</td>
            <td align="center">Hacer un movimiento en un juego simple </td>
            <td align="center"> <b>Como </b>jugador <b>Quiero</b> anotar una letra en una casilla <b>Para</b> formar un SOS</td>
            <td align="center"> ALTA </td>
            <td align="center"> 2 </td>
        </tr>
        <tr>
            <td align="center">5</td>
            <td align="center"> Un juego simple ha terminado</td>
            <td align="center"> <b>Como </b>jugador<b> Quiero </b>escribir un SOS <b> Para </b>ganar la partida</td>
            <td align="center"> MEDIA</td>
            <td align="center">5 </td>
        </tr>
        <tr>
            <td align="center">6</td>
            <td align="center">Hacer un movimiento en un juego general</td>
            <td align="center"> <b>Como </b>jugador<b> Quiero </b>anotar una letra en una casilla<b> Para </b>formar varios SOS</td>
            <td align="center"> ALTA </td>
            <td align="center"> 2 </td>
        </tr>
        <tr>
            <td align="center">7</td>
            <td align="center">Un juego general ha terminado</td>
            <td align="center"><b>Como </b>jugador<b> Quiero </b>escribir la mayor cantidad de SOS<b> Para</b> ganar la partida</td>
            <td align="center"> MEDIA </td>
            <td align="center"> 5 </td>
        </tr>
    </tbody>
</table>


## 2. Criterios de aceptación (AC)

<table>
    <thead>
        <tr>
            <th>Nombre e ID de la historia usuario(AC)</th> 
            <th>ID</th>
            <th>Descripción de los criterios de aceptación</th>
            <th>Estatus (completado, por hacer, en progreso) </th>
        </tr>
        <tr>
            <td align="center">5. Un juego simple ha terminado</td>
            <td align="center">5.1
</td>
            <td align="center"> AC 5.1 "Hay un ganador": <b>Dado</b> un juego simple<b> Cuando</b> un jugador completa un SOS <b>Entonces</b> acaba el juego y se le declara ganador </td>
            <td align="center"> Por hacer</td>
        </tr>
        <tr>
            <td rowspan = 2 align="center">7. Un juego general ha terminado</td>
            <td align="center"> 7.1</td>
            <td align="center">AC 7.1 "Tablero lleno":<b>Dado</b> un juego general <b>Cuando</b> el tablero se llene <b>Entonces</b> acaba el juego</td>
            <td align="center"> Por hacer</td>
        </tr>
        <tr>
            <td align="center"> 7.2 </td>
            <td align="center"> AC 7.2 "Hay un ganador": <b>Dado</b> un juego general con tablero lleno <b>Cuando</b> un jugador tenga más SOS que el otro <b>Entonces</b> se le declara ganador </td>
            <td align="center"> Por hacer</td>
        </tr>
    </thead>
</table>
