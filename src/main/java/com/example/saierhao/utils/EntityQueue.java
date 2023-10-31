package com.example.saierhao.utils;

import com.example.saierhao.generator.domain.Fairybook;
import com.example.saierhao.generator.domain.Wizarddetail;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @date 2023年06月28日 16:36
 */
@Component
public class EntityQueue {

    private static final List<Fairybook> fairyBookList = new ArrayList<>();
    private static final List<Wizarddetail> wizarddetailList = new ArrayList<>();

    public void addFairyBook(Fairybook fairybook){
        fairyBookList.add(fairybook);
    }

    public List<Fairybook> getFairyBookList(){
        return fairyBookList;
    }

    public void clearFairyBookList(){
        fairyBookList.clear();
    }

    public void addWizarddetail(Wizarddetail wizarddetail){
        wizarddetailList.add(wizarddetail);
    }

    public List<Wizarddetail> getWizarddetailList(){
        return wizarddetailList;
    }

    public void clearWizarddetailList(){
        wizarddetailList.clear();
    }



}
