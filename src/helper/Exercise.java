/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 *
 * @author cjwn
 */
public class Exercise {
    private String name;
    private String category;
    private String subcategory;
    private String description;
    
    public Exercise(String exerciseName, String exerciseCat, String exerciseSubCat, String exerciseDesc) {
        name = exerciseName;
        category = exerciseCat;
        subcategory = exerciseSubCat;
        description = exerciseDesc;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void printExercise() {
        System.out.println("Exercise Name: " + name);
        System.out.println("Category: " + category + ", subcategory: " + subcategory);
        System.out.println(description);
    }
    
}
