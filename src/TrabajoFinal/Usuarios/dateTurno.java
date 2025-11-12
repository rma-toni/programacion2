package TrabajoFinal.Usuarios;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class dateTurno implements Serializable {

    LocalTime hora;
    LocalDate fecha;
    boolean disponible;

    public dateTurno(LocalTime hora, LocalDate fecha){
        this.hora = hora;
        this.fecha = fecha;
        disponible = true;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
