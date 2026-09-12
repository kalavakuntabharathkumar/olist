# Olist data import

The Brazilian E-Commerce public dataset contains multiple CSV tables. Do not commit the dataset if its distribution terms do not permit redistribution.

For this portfolio project, map the relevant tables into:
- customers
- orders
- order_items
- products
- sellers
- categories

Recommended import flow:
1. Create the schema with `ddl-auto=update` for local development.
2. Import customers, orders, products, sellers, and order items.
3. Preserve Olist identifiers as business keys.
4. Add indexes on `orders.customer_id`, `orders.order_status`, `order_items.order_id`, and `order_items.product_id`.
5. Validate row counts against the source dataset.
