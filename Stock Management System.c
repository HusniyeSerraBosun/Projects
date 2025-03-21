#include <stdio.h>
#include <stdlib.h>
#include <string.h> 

#define MAX_PRODUCTS 100

typedef struct 
{
    char ID[100];
    char name[500];
    char unit[100];
    int quantity;
} Product;

void menu()
{
    printf("\n---------Product Stock System --------\n");
    printf("MENU:\n");
    printf(" 1.  Add a product\n");
    printf(" 2.  Update a product\n");
    printf(" 3.  Search for a product with name\n");
    printf(" 4.  Increase quantity of a product\n");
    printf(" 5.  Decrease quantity of a product\n");
    printf(" 6.  List all products\n");
    printf(" 7.  Exit\n");
}

int read(Product *products)
{
    FILE *file;
    file = fopen("products.txt", "r");
    if (file == NULL)
    {
        printf("File is not opened\n");
        return 0;
    }

    char buffer[500];
    int index = 0;

    while (fgets(buffer, sizeof(buffer), file) != NULL && index < MAX_PRODUCTS)
    {   
        char *ID_str = strtok(buffer, ",");
        char *name_str = strtok(NULL, ",");
        char *unit_str = strtok(NULL, ",");
        char *quantity_str = strtok(NULL, ",");

        if (ID_str && name_str && unit_str && quantity_str)
        {
            strcpy(products[index].ID, ID_str);
            strcpy(products[index].name, name_str);
            strcpy(products[index].unit, unit_str);
            products[index].quantity = atoi(quantity_str);
            index++;
        }
    }

    fclose(file);

    return index;
}

int productAdd()
{
    Product newProduct;
    FILE* file;
    file = fopen("products.txt", "a");
    if (file == NULL)
    {
        return 1;
    }
    
    printf(" ID: ");
    scanf("%s", newProduct.ID);

    printf("\n");

    getchar();
    printf(" NOTE: Please capitalize the first letters of the product 'name' you entered to avoid errors.\n ");
    printf("Name: ");
    scanf("%[^\n]", newProduct.name);

    getchar();

    printf(" Unit: ");
    scanf("%[^\n]", newProduct.unit);
    getchar();

    printf(" Quantity: ");
    scanf("%d", &newProduct.quantity);

    fprintf(file, "%s,%s,%s,%d\n", newProduct.ID, newProduct.name, newProduct.unit, newProduct.quantity);

    fclose(file);

    return 0;
}

int update(Product *products)
{
    int numProducts = read(products);
    char updateID[100];
    printf("Enter the ID of the product to update: ");
    scanf("%s", updateID);

    int foundIndex = -1;
    for (int i = 0; i < numProducts; i++)
    {
        if (strcmp(products[i].ID, updateID) == 0)
        {
            foundIndex = i;
            break;
        }
    }

    if (foundIndex == -1)
    {
        printf("Product with ID %s not found.\n", updateID);
        return 1;
    }

    printf("Which field do you want to update?\n");
    printf("1. ID\n");
    printf("2. Name\n");
    printf("3. Unit\n");
    printf("4. Quantity\n");
    int choice;
    printf("Enter your choice (1-4): ");
    scanf("%d", &choice);

    char newValue[500];
    int newQuantity;
    if (choice != 4)
    {
        printf("Enter the new value: ");
        getchar(); 
        scanf("%[^\n]", newValue);
    }

    switch (choice)
    {
    case 1:
        strcpy(products[foundIndex].ID, newValue);
        break;
    case 2:
        strcpy(products[foundIndex].name, newValue);
        break;
    case 3:
        strcpy(products[foundIndex].unit, newValue);
        break;
    case 4:
        printf("Enter the new quantity: ");
        scanf("%d", &newQuantity);
        products[foundIndex].quantity = newQuantity;
        break;
    default:
        printf("Invalid choice.\n");
        return 1;
    }

    FILE *file;
    file = fopen("products.txt", "w");
    if (file == NULL)
    {
        printf("File is not opened\n");
        return 1;
    }

    for (int i = 0; i < numProducts; i++)
    {
        fprintf(file, "%s,%s,%s,%d\n", products[i].ID, products[i].name, products[i].unit, products[i].quantity);
    }

    fclose(file);

    printf("Product with ID %s successfully updated.\n", updateID);

    return 0;
}

void searchProductName(Product *products)
{
    int numProducts = read(products);
    char searchName[500];
    printf("NOTE: Please capitalize the first letters of the product name you entered to avoid errors.\n ");
    printf("Enter the name of the product to search: ");
    getchar();
    scanf("%[^\n]", searchName);

    int found = 0;
    printf("-----------------------List of products based on search results------------------------\n");
    printf(" %-15s  %-50s  %-10s  %-10s \n", "ID", "NAME", "UNIT", "QUANTITY");
    printf("\n");
    for (int i = 0; i < numProducts; i++)
    {
        if (strstr(products[i].name, searchName) != NULL)
        {
            printf(" %-15s  %-50s  %-10s  %-10d \n", 
                    products[i].ID, 
                    products[i].name, 
                    products[i].unit, 
                    products[i].quantity);
            found = 1;

        }
    }

    if (!found)
    {
        printf("Product with name %s not found.\n", searchName);
    }
}

int increaseProduct(Product *products)
{
    int numProducts = read(products);
    char increaseID[100];
    printf("Enter the ID of the product quantity to increase: ");
    scanf("%s", increaseID);

    int foundIndex = -1;
    for (int i = 0; i < numProducts; i++)
    {
        if (strcmp(products[i].ID, increaseID) == 0)
        {
            foundIndex = i;
            break;
        }
    }

    if (foundIndex == -1)
    {
        printf("Product with ID %s not found.\n", increaseID);
        return 1;
    }

    printf("Enter the increase amount: ");
    int increaseAmount;
    scanf("%d", &increaseAmount);

    products[foundIndex].quantity += increaseAmount;

    FILE *file;
    file = fopen("products.txt", "w");
    if (file == NULL)
    {
        printf("File is not opened\n");
        return 1;
    }

    for (int i = 0; i < numProducts; i++)
    {
        fprintf(file, "%s,%s,%s,%d\n", products[i].ID, products[i].name, products[i].unit, products[i].quantity);
    }

    fclose(file);

    printf("Product with ID %s successfully updated.\n", increaseID);

    return 0;
}

int decreaseProduct(Product *products)
{
    int numProducts = read(products);
    char decreaseID[100];
    printf("Enter the ID of the product quantity to decrease: ");
    scanf("%s", decreaseID);

    int foundIndex = -1;
    for (int i = 0; i < numProducts; i++)
    {
        if (strcmp(products[i].ID, decreaseID) == 0)
        {
            foundIndex = i;
            break;
        }
    }

    if (foundIndex == -1)
    {
        printf("Product with ID %s not found.\n", decreaseID);
        return 1;
    }

    printf("Enter the decrease amount: ");
    int decreaseAmount;
    scanf("%d", &decreaseAmount);

    products[foundIndex].quantity -= decreaseAmount;

    FILE *file;
    file = fopen("products.txt", "w");
    if (file == NULL)
    {
        printf("File is not opened\n");
        return 1;
    }

    for (int i = 0; i < numProducts; i++)
    {
        fprintf(file, "%s,%s,%s,%d\n", products[i].ID, products[i].name, products[i].unit, products[i].quantity);
    }

    fclose(file);

    printf("Product with ID %s successfully updated.\n", decreaseID);

    return 0;
}

int productList()
{
    Product products[MAX_PRODUCTS];
    int numProducts = read(products);
    if (numProducts == 0)
    {
        printf("No products found.\n");
        return 1;
    }

    printf("------------------------------PRODUCTS LIST-------------------------------\n");
    printf(" %-15s  %-50s  %-10s  %-10s \n", "ID", "NAME", "UNIT", "QUANTITY");
    printf("\n");

    for (int i = 0; i < numProducts; i++)
    {
        printf(" %-15s  %-50s  %-10s  %-10d \n", 
               products[i].ID, 
               products[i].name, 
               products[i].unit, 
               products[i].quantity);
    }

    return 0;
}

int main()
{
    int choice;
    Product products[MAX_PRODUCTS];

    do {
        menu();
        printf("Enter your choice (1-7): ");
        scanf("%d", &choice);

        switch (choice)
        {
            case 1:
                if (productAdd() == 0)
                    printf("Product is added successfully\n");
                else
                    printf("Product is not added\n");
                break;
            case 2:
                update(products);
                break;
            case 3:
                searchProductName(products);
                break;
            case 4:
                increaseProduct(products);
                break;
            case 5:
                decreaseProduct(products);
                break;
            case 6:
                productList();
                break;
            case 7:
                return 0;
            default:
                printf("Invalid choice. Please enter a number between 1 and 7.\n");
        }
    } while (choice != 7);

    getch();
}
