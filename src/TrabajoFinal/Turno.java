package TrabajoFinal;
import TrabajoFinal.Usuarios.Medico;
import TrabajoFinal.Usuarios.Paciente;
import TrabajoFinal.Usuarios.dateTurno;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Turno implements Serializable {

    private dateTurno horaFecha;
    private LocalDate fecha; //TODO ELIMINAR
    private LocalTime hora; //TODO ELIMINAR
    private Paciente paciente;
    private Medico medico;
    private boolean estado;

    //Contructor
    public Turno(dateTurno date, Paciente paciente, Medico medico, boolean estado) {

        this.horaFecha = date;
        this.fecha = date.getFecha();
        this.hora = date.getHora();
        this.paciente = paciente;
        this.medico = medico;
        this.estado = estado;
    }


    // Getter y Setter
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public dateTurno getDateTurno() {
        return horaFecha;
    }

    //TO String
    @Override
    public String toString() {
        return "Turnos [fecha=" + fecha + ", hora=" + hora + ", paciente=" + paciente.getNombre() + ", medico=" + medico.getNombre()
                + ", especialidad=" + medico.getEspecialidad() + ", estado=" + estado + "]";
    }
}
