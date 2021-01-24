package com.company.util;

import com.company.entity.Instructor;

public class PrintInstructors {

    public static String printInstructor(Instructor instructor){

        StringBuilder sb = new StringBuilder();
        sb.append("Instructor { \n");
        sb.append("\tId: " + instructor.getId() + "\n");
        sb.append("\tFirstName: " + instructor.getFirstName() + "\n");
        sb.append("\tLastName: " + instructor.getLastName() + "\n");
        sb.append("\tEmail: " + instructor.getEmail() + "\n");
        sb.append("\tInstructorDetail { \n");
        sb.append("\t\tId: " + instructor.getInstructorDetail().getId() + "\n");
        sb.append("\t\tYoutube Channel: " + instructor.getInstructorDetail().getYoutubeChannel() + "\n");
        sb.append("\t\tWebSite: " + instructor.getInstructorDetail().getWebsite()+ "\n");
        sb.append("\t}\n,");
        sb.append("\tCourse [ \n");
        for (int i = 0; i <instructor.getCourses().size() ; i++) {
            sb.append("\t\tTitle: " + instructor.getCourses().get(i).getTitle() + "\n");
            sb.append("\t\t\tReviews: [\n");
            for (int j = 0; j <instructor.getCourses().get(i).getReviews().size(); j++) {
                sb.append("\t\t\t\tComment: " + instructor.getCourses().get(i).getReviews().get(j).getComment() + "\n");
            }
            sb.append("\t\t\t]\n");
        }
        sb.append("\t]\n");
        sb.append("}\n");
        return sb.toString();
    }
}
