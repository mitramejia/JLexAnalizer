/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

/**
 *
 * @author mitramejia
 * This class counts how many expressions have been e
 */
public class ExpressionCounter {
    
    private int sectionCount;
    
    public ExpressionCounter() {
        this.sectionCount = 0;
    }
    
    public void resetCount() {
        this.setExpressioCount(0);
    }

    public void increaseSectionCount(){
        this.sectionCount++;
    }
    
    /**
     * @return the sectionCount
     */
    public int getExpressioCount() {
        return sectionCount;
    }
   
    /**
     * @param sectionCount the sectionCount to set
     */
    public void setExpressioCount(int sectionCount) {
        this.sectionCount = sectionCount;
    }
    
}
