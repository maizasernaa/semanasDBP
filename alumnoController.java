/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import beans.Alumno;
import java.util.List;
import model.alumnoModel;

/**
 *
 * @author user
 */
public class alumnoController {
    
    public List<Alumno> getLstAlumnoController(){
       
        
        return new alumnoModel().getLstAlumnoModel();
    }
}
