var RandomizedCollection = function() {
    this.list = [];
    this.map = new Map();
};

/** 
 * @param {number} val
 * @return {boolean}
 */
RandomizedCollection.prototype.insert = function(val) {
    if (!this.map.has(val)) {
        this.map.set(val, new Set());
    }
    this.map.get(val).add(this.list.length);
    this.list.push(val);
    return this.map.get(val).size === 1;
};

/** 
 * @param {number} val
 * @return {boolean}
 */
RandomizedCollection.prototype.remove = function(val) {
    if (!this.map.has(val) || this.map.get(val).size === 0) {
        return false;
    }

    // Get arbitrary index of the value to remove
    let indexToRemove = this.map.get(val).values().next().value;
    this.map.get(val).delete(indexToRemove);

    // If the element to remove is not the last one in the list
    if (indexToRemove !== this.list.length - 1) {
        let lastElement = this.list[this.list.length - 1];
        this.list[indexToRemove] = lastElement;
        this.map.get(lastElement).delete(this.list.length - 1);
        this.map.get(lastElement).add(indexToRemove);
    }

    this.list.pop();
    return true;
};

/**
 * @return {number}
 */
RandomizedCollection.prototype.getRandom = function() {
    const randomIndex = Math.floor(Math.random() * this.list.length);
    return this.list[randomIndex];
};

/** 
 * Your RandomizedCollection object will be instantiated and called as such:
 * var obj = new RandomizedCollection()
 * var param_1 = obj.insert(val)
 * var param_2 = obj.remove(val)
 * var param_3 = obj.getRandom()
 */
