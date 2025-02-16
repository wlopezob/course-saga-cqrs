# Saga Pattern Project

## Execution Order

The projects should be executed in the following order of the name folder using `gradle bootRun`:

## Project Documentation

### API Documentation
- The Postman collection with all API endpoints can be found in the `/collection` folder.

### Architecture Documentation
- The project's architectural diagram and design documentation can be found in the `/app` folder.

## Important Notes
- Make sure each service is fully started before launching the next one
- The Config Server must be the first service to start as other services depend on it
- The Service Registry (Eureka) should be the second service to start
- The API Gateway should be running before starting the business services (Order, Payment, Inventory)

