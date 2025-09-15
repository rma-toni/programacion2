package Practica3;

//TODO Seleccion de sexo restringida
//TODO Probar diferentes casos e intentar forzar error

import java.util.ArrayList;
import java.util.Objects;

public class tester {
    public static void main(String[] args) {
        int opcion = -1;
        ArrayList<Asignatura> asignaturas = new ArrayList<>();
        while (true){
            System.out.println("---------- MENU ----------");
            System.out.println("1 - Crear materia");
            System.out.println("2 - Mostrar materias");
            System.out.println("3 - Inscribir alumno a materia");
            System.out.println("4 - Mostrar alumnos inscriptos a una materia");
            System.out.println("0 - Salir del programa");
            opcion = Helper.getInteger("Ingrese la opcion elegida: ");
            switch (opcion){
                case 1:
                    asignaturas.add(crearAsignatura());
                    break;
                case 2:
                    mostrarAsignaturas(asignaturas);
                    break;
                case 3:
                    inscribirAlumno(asignaturas);
                    break;
                case 4:
                    mostrarAlumnos(asignaturas);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opcion invalida, ingrese una opcion valida");
            }
        }

    }

    public static Asignatura crearAsignatura(){
        String nombre = Helper.getString("Ingrese el nombre de la meteria: ");
        int anio = Helper.getInteger("Ingrese el año al que corresponde la materia: ");
        int horas = Helper.getInteger("Ingrese la cantidad de horas que tiene la materia: ");
        return new Asignatura(nombre, anio, horas);
    }

    public static void mostrarAsignaturas(ArrayList<Asignatura> asignaturas){
        for (Asignatura asignatura : asignaturas){
            System.out.println(asignatura.toString());
        }
    }

    public static void inscribirAlumno(ArrayList<Asignatura> asignaturas){
        String seleccionMateria = Helper.getString("Ingrese la materia a la que desea inscribir al alumno: ");
        boolean control = false;
        for (Asignatura asignatura : asignaturas){
            if (Objects.equals(asignatura.getNombre(), seleccionMateria)){
                control = true;
                asignatura.inscribirAlumno(crearAlumno());
            }
        }
        if (control == false){
            System.out.println("No se encontro la meteria ingresada.");
        }else{
            System.out.println("Alumno inscripto.");
        }
    }

    public static void mostrarAlumnos(ArrayList<Asignatura> asignaturas){
        String seleccionMateria = Helper.getString("Ingrese la materia para mostrar sus alumnos: ");
        boolean control = false;
        for (Asignatura asignatura : asignaturas){
            control = true;
            if (Objects.equals(asignatura.getNombre(), seleccionMateria)){
                System.out.println("1 - Mostrar todos los alumnos inscriptos.");
                System.out.println("2 - Mostrar los alumnos en una condicion especifica.");
                System.out.println("3 - Mostrar los alumnos ordenados por nota.");
                System.out.println("4 - Mostrar los alumnos ordenados por nombre.");
                System.out.println("5 - Mostrar los alumnos ordenados por apellido.");
                int option = Helper.getInteger("Ingrese la opcion elegida: ");
                switch (option){
                    case 1:
                        asignatura.mostrarAlumnos();
                        break;
                    case 2:
                        asignatura.mostrarAlumnosCondicion(Helper.getString("Ingrese la condicion buscada: "));
                        break;
                    case 3:
                        asignatura.mostarAlumnosOrdenadosPorNota();
                        break;
                    case 4:
                        asignatura.mostrarAlumnosOrdenadosPorNombre();
                        break;
                    case 5:
                        asignatura.mostrarAlumnosOrdenadosPorApellido();
                        break;
                    default:
                        System.out.println("La opcion ingresada es invalida.");
                }
            }
        }
        if (control == false){
            System.out.println("No se encontro la meteria ingresada.");
        }
    }

    public static Alumno crearAlumno(){
        String nombre = Helper.getString("Ingrese el nombre del alumno: ");
        String apellido = Helper.getString("Ingrese el apellido del alumno: ");;
        String lu = Helper.getString("Ingrese la libreta universitaria del alumno: ");;
        String sexo = Helper.getString("Ingrese el sexo del alumno: ");;
        String condicion = Helper.getString("Ingrese la condicion del alumno: ");
        int notaFinal = Helper.getInteger("Ingrese la nota final del alumno: ");

        return new Alumno(nombre,apellido,lu,sexo,condicion,notaFinal);
    }
}
