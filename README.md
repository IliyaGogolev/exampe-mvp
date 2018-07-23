# exampe-mvp


Example of android application of MVP and clean architecture approach. Used Kotlin, Dagger2, RxJava, Retrofit.
This app has 3 screens and retreives data from mock API of apiary server:

1. Login screen
2. List of plans
3. Plan Detials


Project strucutre.
There're two main features "login" and "plan". Plan feature has two sub features "plans" and "plandetails"

- features
  - login
  - plan
    - plans          <--  list of plans
    - plandetails    <--- plan details

Each feature has three layers :
* data - data and repositories which provided the data
* domain - responsible for business logic
* presentation - represents UI related logic

There are three types of data objects
* Raw data - represents server API/network data, used to remove dependencies between back-end and to app. In case there's api change, only raw data and mapper classes should be fixed, no more fixed required in the project
* App Data - represents application/features data 
* ViewData - data which used inside UI, used to encapsulated and seperate UI layer from domain 


TODO: This is very basic sample app. A lot of improvements can be done by using architecture components and best practices (Lifecycle, LiveData, Paging, etc...) Everybody is welcome to contribute :)
