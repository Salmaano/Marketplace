# Marketplace
A simple e-commerce web application for buying and selling goods.

 - You can sign in as a buyer and go through available listings to place an order
 - You can sign in as a seller and post listings of items you want to sell

What the application can do so far:

- Five end points have been defined and are fully functional:
  - /buyer/create - create a buyer user
  - /seller/create - create a seller user
  - /buyer_id/makeOrder - place an order as a buyer
  - /listings - show all available listings
  - /seller_id/listings - show all listings specific to a seller

- A simple front-end has been partially made:
  - It can show available listings
  - You can sign up as a buyer
  - The front end has been put on hold at the moment

I have added annotation based validations and generic exception handling. 
At the moment, I am working on refactoring my code and adding a DAO layer to interface between the repositories and the controllers to follow
good coding practice. This is because my code was not packaged ideally and was not separating application and business logic well enough. 
I am also doing this to add custom validation to resource entity attributes.
