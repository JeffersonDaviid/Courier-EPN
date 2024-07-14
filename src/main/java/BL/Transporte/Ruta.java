package BL.Transporte;

public class Ruta {

    String sector;
    String direccion;

    public Ruta(String sector, String direccion) {
        this.sector = sector;
        this.direccion = direccion;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public  void consultarRuta() {
        String rutaInfo = "\n*************************************\n" + 
                          "         INFORMACION DE LA RUTA          \n" + 
                          "\n*************************************\n" +
                          "Sector:       " + sector + "\n" + 
                          "Direccion:    " + direccion + "\n" + 
                          "\n*************************************\n";
        System.out.println(rutaInfo);
    } 
}
