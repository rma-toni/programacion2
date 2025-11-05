package TrabajoFinal;
import TrabajoFinal.Usuarios.Medico;
import TrabajoFinal.Usuarios.Paciente;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {

    private LocalDate fecha;
    private LocalTime hora;
    private Paciente paciente;
    private Medico medico;
    private boolean estado;

    //Contructor
    public Turno(LocalDate fecha, LocalTime hora, Paciente paciente, Medico medico, boolean estado) {

        this.fecha = fecha;
        this.hora = hora;
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


    //TO String
    @Override
    public String toString() {
        return "Turnos [fecha=" + fecha + ", hora=" + hora + ", paciente=" + paciente + ", medico=" + medico
                + ", estado=" + estado + ", getFecha()=" + getFecha() + ", getHora()=" + getHora() + ", getPaciente()="
                + getPaciente() + ", getMedico()=" + getMedico() + ", getEstado()=" + getEstado() + "]";
    }
}
