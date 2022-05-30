/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;
import model.*;
/**
 *
 * @author user
 */
public class BarangController {
    View view;
    
    public BarangController(View tampilan){
        this.view = tampilan;
        
        view.getTambah().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Model model = new Model();
                View_Input input = new View_Input();
                view.setVisible(false);
                InputController inputcontroller = new InputController(model,input);
            }
        });
        
        view.getLihat().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Model model = new Model();
                View_Lihat read = new View_Lihat();
                view.setVisible(false);
                ReadController readcontroller = new ReadController(read,model);
            }
        });
    }
}
