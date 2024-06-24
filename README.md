

### Endpoints

1. **Update Budget**
   - **Endpoint**: `PUT /budget/update/{id}`
   - **Description**: Updates an existing budget.
   - **Parameters**: 
     - `id` (path, required): The unique identifier of the budget.
   - **Request Body**: Budget object with updated details.
   - **Responses**: 
     - `200 OK`: Budget updated successfully.
     - `500 Internal Server Error`: Server error.

2. **Create Budget**
   - **Endpoint**: `POST /budget/create`
   - **Description**: Creates a new budget.
   - **Request Body**: Budget object with budget details.
   - **Responses**: 
     - `201 Created`: Budget created successfully.
     - `500 Internal Server Error`: Server error.

3. **Get Budgets by User**
   - **Endpoint**: `GET /budget/user/{userId}`
   - **Description**: Retrieves budgets for a specific user.
   - **Parameters**: 
     - `userId` (path, required): The unique identifier of the user.
   - **Responses**: 
     - `200 OK`: List of budgets retrieved.
     - `500 Internal Server Error`: Server error.

4. **Get Budgets by User and Category**
   - **Endpoint**: `GET /budget/user/{userId}/category/{categoryId}`
   - **Description**: Retrieves budgets for a specific user and category.
   - **Parameters**: 
     - `userId` (path, required): The unique identifier of the user.
     - `categoryId` (path, required): The unique identifier of the category.
   - **Responses**: 
     - `200 OK`: List of budgets retrieved.
     - `500 Internal Server Error`: Server error.

5. **Get All Categories**
   - **Endpoint**: `GET /budget/categories`
   - **Description**: Retrieves all budget categories.
   - **Responses**: 
     - `200 OK`: List of categories retrieved.
     - `500 Internal Server Error`: Server error.

### Components

1. **Budget**
   - **Properties**: 
     - `id` (integer): Budget ID.
     - `userId` (integer): User ID.
     - `category` (object): Budget category.
     - `amount` (number): Budget amount.
     - `createdAt` (string): Creation timestamp.
     - `updatedAt` (string): Update timestamp.
   - **Required**: `amount`

2. **BudgetCategory**
   - **Properties**: 
     - `id` (integer): Category ID.
     - `name` (string): Category name.

3. **ErrorResponse**
   - **Properties**: 
     - `apiPath` (string): API path invoked.
     - `errorCode` (string): Error code.
     - `errorMessage` (string): Error message.
     - `errorTime` (string): Error timestamp.
