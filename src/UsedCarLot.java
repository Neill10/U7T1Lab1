import java.util.ArrayList;

public class UsedCarLot
{
    // the car lot's inventory
    private ArrayList<Car> inventory;

    // constructs a new UsedCarLot object
    // sets inventory to an empty ArrayList of Cars
    public UsedCarLot()
    {
        inventory = new ArrayList<Car>();
    }

    // getter method: returns the inventory
    public ArrayList<Car> getInventory()
    {
        return inventory;
    }

    // adds a Car to the end of the inventory list
    public void addCar(Car carToAdd)
    {
        inventory.add(carToAdd);
    }

    // swaps the Car at idx1 with the Car at idx2 in inventory;
    // however, if either idx1 or idx2 exceed the bounds of the inventory,
    // do nothing (rather than crashing!).
    //
    // this method MODIFIES the state of the object (its inventory)
    public void swap(int idx1, int idx2)
    {
        if(idx1<inventory.size() && idx2<inventory.size())
        {
            Car car = inventory.get(idx1);
            inventory.set(idx1, inventory.get(idx2));
            inventory.set(idx2, car);
        }
    }
    /* Adds a Car to the inventory list at the index specified
     by indexToAdd; this method increases the size of inventory by 1

     PRECONDITION: indexToAdd < inventory.size()
   */
    public void addCar(int indexToAdd, Car carToAdd)
    {
        inventory.add(indexToAdd,carToAdd);
    }

    /* "sells" the Car located at indexOfCarToSell which
        removes it from the inventory list and shifting the remaining
        Cars in the inventory list to the left to fill in the gap;
        this method reduces the size of inventory by 1

        @return returns the Car that is being "sold" (removed from lot)

        PRECONDITION: indexOfCarToSell < inventory.size()

        HINT: the ArrayList remove() method returns the removed element...
      */
    public Car sellCarShift(int indexOfCarToSell)
    {
        Car removed = inventory.remove((indexOfCarToSell));
        return removed;

    }

    /* "sells" the Car located at indexOfCarToSell,
       but instead of removing it and shifting the inventory
       list to the left, REPLACE the Car at indexOfCarToSell
       with NULL, thus creating an "empty parking spot" on the lot;
       this method does NOT reduce the size of inventory by 1

       PRECONDITION: indexOfCarToSell < inventory.size()

       @return returns the Car that is being "sold" (replaced with null)
     */
    public Car sellCarNoShift(int indexOfCarToSell)
    {
        Car removed = inventory.remove(indexOfCarToSell);
        inventory.set(indexOfCarToSell,null);
        return removed;
    }

    /* moves Car located at index indexOfCarToMove to index destinationIndex;
       if destinationIndex > indexOfCarToMove, moves the Car to the right in
       inventory list; if destinationIndex < indexOfCarToMove, moves the
       Car to the left in inventory list

       PRECONDITIONS: indexOfCarToMove < inventory.size()
                      destinationIndex < inventory.size()
     */
    public void moveCar(int indexOfCarToMove, int destinationIndex)
    {
        Car movedCar = inventory.get(indexOfCarToMove);
        if(indexOfCarToMove < destinationIndex) {
            for (int i = indexOfCarToMove + 1; i < destinationIndex; i++) {
                inventory.remove(indexOfCarToMove);
                inventory.add(destinationIndex, movedCar);
            }
        }
        else
        {
            Car at = inventory.get(destinationIndex);
            inventory.remove(indexOfCarToMove);
            inventory.remove(destinationIndex);
            for(int x = 0; x < inventory.size();x++)
            {
                if (x == 0) {
                    Car shift = inventory.get(x);
                    inventory.add(shift);
                    inventory.remove(x);
                }
            }
            inventory.add(destinationIndex,at);
            inventory.add(destinationIndex,movedCar);
        }
        //TEST #7 -- *****FAIL*****
        // Expected: [Mustang 12500mi, Accent 1980mi, Cruiser 10500mi, Ram 17200mi, Camry 8400mi]
        //   Actual: [Accent 1980mi, Camry 8400mi, Cruiser 10500mi, Ram 17200mi, Mustang 12500mi]

    }

}
