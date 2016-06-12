/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

/**
 *
 * @author mitramejia
 */
public class SectionManager {
    
    private int sectionCount;
    
    public SectionManager() {
        this.sectionCount = 0;
    }
    
    public void resetSections(){
        this.setSectionCount(0);
    }

    public void increaseSectionCount(){
        this.sectionCount++;
    }
    
    /**
     * @return the sectionCount
     */
    public int getSectionCount() {
        return sectionCount;
    }
   

    /**
     * @param sectionCount the sectionCount to set
     */
    public void setSectionCount(int sectionCount) {
        this.sectionCount = sectionCount;
    }
    
}
