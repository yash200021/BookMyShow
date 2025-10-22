# BookMyShow
I am coding BookMyShow MVP version end-to-end, using MySQL for data Persistence.

Note :- if we are creating Mapping class for two classes like XY, where individual classes X and Y are attributes of XY, then
Cardinality between mapping class and Individual class will always be many to one.

XY  --> X (Many to One)
XY  --> Y (Many to One)

/*
1. Validate and fetch the UserId from DB, if not found throw an exception.
2. Fetch the showSeat objects from DB.
3. Check If showSeats are available, if not Throw an exception.

        -----  TAKE A LOOK ----

        4. Check the showSeat status again.
        5. Change the status to BLOCKED.
        ---  RELEASE THE LOCK  ------
        6. Create the cooking with pending status.
        7. Move to payment Page.

Although we have not implemented this approach, but this is more optimal than using @Transactional annotation at service layer.
*/