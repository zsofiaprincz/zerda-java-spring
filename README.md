# EXAM: Java Spring

### Getting Started
 - Fork this repository under your own account
 - Clone the forked repository to your computer
 - As opposed to the usual thing, please **commit only ONCE, at the end of the exam**
 - Go through the whole description before starting it

### What can I use?
 - You can use any resource online, but **please work individually**
 - Instead of copy-pasting your answers and solutions, write them in your own words.

# Tasks
### Setup a new project
- Create a new Spring Boot project inside your cloned repository
- Setup `.gitignore` file to exclude the IDE's generated files
   - the src directory should be committed (containing all java and resource files)
   - the gradle related files should be committed
   - the gitignore should be committed
- Create a package called `com.greenfox.exams.spring` and work under that

### Welcome page
- the frontend should have the following components:
    - a paragraph of text containing this copy: "Thank you for visiting our website! To get early access to our planned projects, please fill in the following quick questionnaire."
    - a textarea with the label "Describe your experience with Green Fox Academy so far"
    - a number input with the label "On a scale of 1 to 10, how likely are you to recommend Green Fox Academy to a friend?"
    - an email input with the label "Your email address:"
    - a button

### Backend
- when data is submitted the backend should
    - check if the email address is valid
        - contains a `@` sign and a dot
    - check if the textarea contains at least 3 of the following: `{"amazing", "awesome", "blithesome", "excellent", "fabulous", "fantastic", "favorable", "fortuitous", "great", "incredible", "ineffable", "mirthful", "outstanding", "perfect", "propitious", "remarkable", "smart", "spectacular", "splendid", "stellar", "stupendous", "super", "ultimate", "unbelievable", "wondrous"}`
    - check if the scale is equal to 10 or greater
- if everything checks out
    - store the data (from the textarea, number input and email input) in the database
    - display the thank you page
- if something's wrong
    - display the welcome page again with a message pointing out what's wrong
- data initialization:
    - Copy the following class to your project, make it run (so create everything that is needed to run)
```java
@Component
public class DataLoader implements CommandLineRunner {
  @Autowired
  ProjectRepo repo;

  @Override
  public void run(String... strings) throws Exception {
    repo.save(new Project("Clash of Zerda", "android"));
    repo.save(new Project("Clash of Zerda", "spring"));
    repo.save(new Project("Zerda Reader", "android"));
    repo.save(new Project("Zerda Reader", "spring"));
    repo.save(new Project("Konnekt Contact Manager", "spring"));
  }
}
```

### Thank you page
- the frontend should have the following components:
    - a heading that reads Projects
    - a paragraph that reads "Early access of Greenfox Academy Zerda Raptor Projects with tech tags"
    - an unordered list of projects that comes from the backend's database:
        - Project name 1: tag1
        - Project name 2: tag2
        - ...
