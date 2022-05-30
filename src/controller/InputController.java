/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.*;
import view.*;

/**
 *
 * @author user
 */
public class InputController {
    Model model;
    View_Input view_input;
    
    public InputController(Model model, View_Input view_input){
        this.model = model;
        this.view_input = view_input;
        
        view_input.bSubmit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                               
                model.InputBarang(view_input.getNama(),view_input.getMassa(),view_input.getHarga());   
                View StartView=new View();
                view_input.setVisible(false);
                BarangController Start=new BarangController(StartView);
            }
        });
    }
}
