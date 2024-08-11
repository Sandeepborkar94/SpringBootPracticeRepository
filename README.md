IMPORTANT GIT COMMAND's:

Initialize the Git repository: git init

Add all your project files to the Git repository : git add .

Commit the added files with a message : git commit -m "Initial commit"

Add Remote Repository:
Copy the URL of your GitHub repository.
Add the remote repository to your local Git repository: git remote add origin <your-repository-URL>

example : git remote add origin https://github.com/Sandeepborkar94/SpringBootPracticeRepository.git

Push your changes to the GitHub repository: git push -u origin master

BASIC TroubleShooting : 

if origin already exists in your local Git repository. 
You can resolve this issue by either updating the existing remote URL or removing the existing remote and adding it again. 
Here are the steps for both options:

Update the Remote URL : git remote set-url origin git@bitbucket.org:my-workspace2711/springbootpracticerepository.git

Remove the Existing Remote : git remote remove origin

Add the Remote Again: git remote add origin git@bitbucket.org:my-workspace2711/springbootpracticerepository.git

Push Your Project to Bitbucket: git push -u origin master

_______________________________________________________________________________

Verify the Branch Name: git branch 

Create the Branch if it Doesn't Exist:git branch first_revision_branch

git checkout first_revision_branch



json_data :
 {
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com"
}
