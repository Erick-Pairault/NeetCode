class DynamicArray {

    int size = 0;
    int capacity = 0;
    int arr[];

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[this.capacity];
    }

    public int get(int i) {
        if(i>=this.capacity) // check that index is within bounds of the array
            return 0;
        return this.arr[i];
    }

    public void set(int i, int n) {
        this.arr[i] = n;
    }

    public void pushback(int n) {
        if(this.size == this.capacity)
            resize();
        this.arr[this.size] = n;
        this.size++;
    }

    public int popback() {
        this.size--; // soft delete
        int val = this.arr[size];
        this.arr[size] = 0;
        return val;
    }

    private void resize() {
        this.capacity *=2;
        int[] new_arr = new int[this.capacity];
        for(int i = 0; i < this.size; i++)
            new_arr[i] = this.arr[i];
        this.arr = new_arr;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
