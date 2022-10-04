/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import beans.Alumno;
import java.util.ArrayList;
import java.util.List;
import bd.Conexion;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author user
 */
public class alumnoModel {
    public List<Alumno>getLstAlumnoModel(){
        
        try{
            List<Alumno>lst= new ArrayList<>();
            CallableStatement s=Conexion.ObtenerConexion().prepareCall("{CALL uspListarTodos}");
            ResultSet rSet= s.executeQuery();
            
            while(rSet.next()){
                Alumno obj= new Alumno();
                obj.setCodigo(rSet.getString("Id_alumno"));
                obj.setPaterno(rSet.getString("alu_paterno"));
                obj.setMaterno(rSet.getString("alu_materno"));
                obj.setNombre(rSet.getString("alu_nombres"));
                obj.setSexo(rSet.getNString("alu_sexo"));
                obj.setCodModular(rSet.getNString("alu_codigo"));
                obj.setEstadoCivil(rSet.getNString("Id_estadocivil"));
                obj.setCorreo(rSet.getNString("alu_email"));
                
                lst.add(obj);
            }
            Conexion.ObtenerConexion().close();
            rSet.close();
            return lst;
            
        }
        catch(SQLException ex){
            System.out.print("ocurrio un error:" +ex.getMessage());
        }
        return null;
    }
}
