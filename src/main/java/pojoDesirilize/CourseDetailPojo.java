package pojoDesirilize;

public class CourseDetailPojo {

    private  String instructor;
    private String expertise;
    private String linkedin;

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getExpertise() {

        return expertise;
    }

    public void setExpertise(String expertise) {

        this.expertise = expertise;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {

        this.linkedin = linkedin;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {

        this.company = company;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {

        this.level = level;
    }

    public CourseData getCourse() {
        return course;
    }

    public void setCourse(CourseData course) {
        this.course = course;
    }

    private String company;
    private int level;
    private CourseData course;
}
