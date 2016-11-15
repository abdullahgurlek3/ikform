/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 */
@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String school;
    String foreignLanguage;
    
    @OneToMany
    @Cascade(CascadeType.ALL)
    List<Language> language;
    
    @OneToMany
    @Cascade(CascadeType.ALL)
    List<Program> program;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
