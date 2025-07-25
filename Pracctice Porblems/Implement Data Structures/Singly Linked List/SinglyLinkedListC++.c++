class Node {
    public:
        int val;
        Node* next;

    // Is using this-> better in this case?
        Node () {
            val = 0;
            next = nullptr;
        }

        Node (int new_value) {
            val = new_value;
            next = nullptr;
        }

        Node (int new_value, Node* new_next) {
            val = new_value;
            next = new_next;
        }

//         Solution Provided:
//         // Constructor that sets 'next' to nullptr by default
//         ListNode(int val) : val(val), next(nullptr) {}
    
//         // Constructor that accepts both value and next node
//         ListNode(int val, ListNode* next) : val(val), next(next) {}
};

class LinkedList {
    private:
        Node* head;
        Node* tail;

    public:
        LinkedList() {
            head = nullptr;
            tail = nullptr;
        }

        int get(int index) {
            if(head == nullptr)
                return -1;
            int i = 0;
            Node* pCur = head;
            while (i < index) {
                pCur = pCur->next;
                if (pCur == nullptr)
                    return -1;
                i++;
            }
            return pCur->val;
        }

        void insertHead(int val) {
            Node* new_head = new Node(val);
            if(head == nullptr) {
                head = new_head;
                tail = new_head;
            } else {
                new_head->next = head;
                head = new_head;
            }
        }
        
        void insertTail(int val) {
            Node* new_tail = new Node(val);
            if (head == nullptr) {
                head = new_tail;
                tail = new_tail;
            } else {
                tail->next = new_tail;
                tail = new_tail;
            }
        }

        bool remove(int index) {
            if (head == nullptr)
                return false;

            if (index == 0) {
                Node* temp = head;
                head = head->next;
                if (head == nullptr) {
                    head = nullptr;
                    tail = nullptr;
                } 
                delete temp;
                return true;
            }

            int i = 0;
            Node* pCur = head;
            while (i < index - 1 && pCur->next != nullptr) {
                pCur = pCur->next;
                i++;
            }

            if (pCur->next == nullptr) 
                return false;

            Node* toDelete = pCur->next;
            pCur->next = toDelete->next;
            if (toDelete == tail) 
                tail = pCur;
            delete toDelete;
            return true;
        }

        vector<int> getValues() {
            vector<int> values;
            Node* pCur = head;
            while(pCur != nullptr) {
                values.push_back(pCur->val);
                pCur = pCur->next;
            }
            return values;
        }
};