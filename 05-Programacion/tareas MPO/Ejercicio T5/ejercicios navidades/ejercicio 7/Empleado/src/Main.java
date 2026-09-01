import model.Empleado;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido a la sala de empleados");
        Empleado empleado = new Empleado("Santiago","12345g",24000);
        System.out.println(empleado.getNombre()+" ha hecho 20 horas extras");
        empleado.agregarHorasExtra(20);
        System.out.println("Su nuevo salario es: "+empleado.calcularSalarioTotal());
        System.out.println("Santiago no has registrado las horas en el total del mes");
        empleado.resetearHorasExtra();
        System.out.println("En cuanto suba la info a RH su salario subirá, ahora es: "+empleado.getSalarioBase());
    }
}