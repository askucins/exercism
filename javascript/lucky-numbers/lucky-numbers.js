// @ts-check

/**
 * Calculates the sum of the two input arrays.
 *
 * @param {number[]} array1
 * @param {number[]} array2
 * @returns {number} sum of the two arrays
 */
export function twoSum(array1, array2) {
  return Number(array1.join('')) + Number(array2.join(''));
}

/**
 * Reverses string based on https://www.freecodecamp.org/news/how-to-reverse-a-string-in-javascript-in-3-different-ways-75e4763c68cb/
 *
 * @param {string} value
 * @returns {string} reversed value
 */
function reverse(value) {
  return value?.split('').reverse().join('') ?? ''
}

/**
 * Checks whether a number is a palindrome.
 *
 * @param {number} value
 * @returns {boolean} whether the number is a palindrome or not
 */
export function luckyNumber(value) {
  let numberAsString = String(value);
  return numberAsString === reverse(numberAsString);
}

/**
 * Determines the error message that should be shown to the user
 * for the given input value.
 *
 * @param {string|null|undefined} input
 * @returns {string} error message
 */
export function errorMessage(input) {
  // let result;
  // if (input === undefined || input === null || input === '') {
  //   result = 'Required field';
  // } else if (isNaN(Number(input)) || Number(input) === 0) {
  //   result = 'Must be a number besides 0'
  // } else {
  //   result = '';
  // }
  // return result;

  // Based on a community solution
  // See: https://exercism.org/tracks/javascript/exercises/lucky-numbers/solutions/ghjk

  let result;
  if (!input) {
    result = 'Required field';
  } else if (input > 0) {
    result = '';
  } else {
    result = 'Must be a number besides 0'
  }
  return result;
}
