# android-mvp-architecture
This repository contains a detailed sample app that implements MVP architecture using Dagger2, GreenDao, and RxJava
<p align="center">
  <img src="https://janishar.github.io/images/mvp-app-pics/mvp-login.png" width="200">
  <img src="https://janishar.github.io/images/mvp-app-pics/main-view.png" width="200">
  <img src="https://janishar.github.io/gifs/mvp-app.gif" width="200">
</p>
#### Architecture Blueprint
![Blueprint](https://janishar.github.io/images/mvp-app-pics/mvp-arch.png)

#### Project Structure
![Blueprint](https://janishar.github.io/images/mvp-app-pics/mvp-project-structure-diagram.png)

####The entire app is packaged into five parts:
1. *data*: It contains all the data accessing and manipulating components.
2. *di*: Dependency providing classes using Dagger2.
3. *ui*: View classes along with their corresponding Presenters.
4. *service*: Services for the application.
5. *utils*: Utility classes.

Classes have been designed in such a way that it could be inherited and could maximize the code reuse.
