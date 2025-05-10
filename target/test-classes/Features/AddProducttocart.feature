Feature: Add the Product to cart

Scenario: User add the product to the Cart

Given User is on HomePage
When User click on product link
And User Add the first product in to the Cart
And User navigate to the cart
Then product should be visiable in the cart  