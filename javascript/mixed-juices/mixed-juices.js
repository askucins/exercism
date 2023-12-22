// @ts-check
//
// The line above enables type checking for this file. Various IDEs interpret
// the @ts-check directive. It will give you helpful autocompletion when
// implementing this exercise.

/**
 * Determines how long it takes to prepare a certain juice.
 *
 * @param {string} name
 * @returns {number} time in minutes
 */
export function timeToMixJuice(name) {
    let result;
    switch (name) {
        case 'Pure Strawberry Joy':
            result = 0.5;
            break;
        case 'Energizer':
            result = 1.5;
            break;
        case 'Green Garden':
            result = 1.5;
            break;
        case 'Tropical Island':
            result = 3;
            break;
        case 'All or Nothing':
            result = 5;
            break;
        default:
            result = 2.5;
    }
    return result;
}

/**
 * Calculates the number of limes that need to be cut
 * to reach a certain supply.
 *
 * @param {number} wedgesNeeded
 * @param {string[]} limes
 * @returns {number} number of limes cut
 */
export function limesToCut(wedgesNeeded, limes) {
    let wedgesCut = 0;
    let limesCut = 0;
    while (wedgesCut < wedgesNeeded && limes.length > 0) {
        let wedges;
        switch (limes.shift()) {
            case 'small':
                wedges = 6;
                limesCut++;
                break;
            case 'medium':
                wedges = 8;
                limesCut++;
                break;
            case 'large':
                wedges = 10;
                limesCut++;
                break;
            default:
                wedges = 0;
        }
        wedgesCut += wedges;
    }
    return limesCut;
}

/**
 * Determines which juices still need to be prepared after the end of the shift.
 *
 * @param {number} timeLeft
 * @param {string[]} orders
 * @returns {string[]} remaining orders after the time is up
 */
export function remainingOrders(timeLeft, orders) {
    do {
        timeLeft -= timeToMixJuice(orders.shift());
    } while (timeLeft > 0 && orders.length > 0);
    return orders;
}
