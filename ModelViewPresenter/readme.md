##How to implement MVP for Android

Well, this is where it all starts to become more diffuse. There are many variations of MVP and everyone can adjust the pattern idea to ​​their needs and the way they feel more comfortable. The pattern varies depending basically on the amount of responsibilities that we delegate to the presenter.

Is the view responsible to enable or disable a progress bar, or should it be done by the presenter? And who decides which actions should be shown in the Action Bar? That’s where the tough decisions begin . I will show how I usually work, but I want this article to be more a place for discussion that strict guidelines on how to apply MVP, because up to know there is no “standard” way to implement it .


## The presenter

The presenter is responsible to act as the middle man between view and model. It retrieves data from the model and returns it formatted to the view. But unlike the typical MVC, it also decides what happens when you interact with the view.

## The View

The view, usually implemented by an Activity (it may be a Fragment, a View… depending on how the app is structured), will contain a reference to the presenter. Presenter will be ideally provided by a dependency injector such as Dagger, but in case you don’t use something like this, it will be responsible for creating the presenter object. The only thing that the view will do is calling a method from the presenter every time there is an interface action (a button click for example).

## The model

In an application with a good layered architecture, this model would only be the gateway to the domain layer or business logic.

##MVP Diagram

<p><a href="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ModelViewPresenter/img/mvp.png" target="_blank"><img src="https://raw.githubusercontent.com/rameshvoltella/AndroidEssentials/master/ModelViewPresenter/img/mvp.png" alt="Screenshot" style="max-width:100%;"></a></p>
