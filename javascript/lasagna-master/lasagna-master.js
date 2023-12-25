/// <reference path="./global.d.ts" />
// @ts-check

/**
 * Implement the functions needed to solve the exercise here.
 * Do not forget to export them so they are available for the
 * tests. Here an example of the syntax as reminder:
 *
 * export function yourFunction(...) {
 *   ...
 * }
 */

/**
 * Calculates cooking status
 *
 * @param {number} timer
 * @returns {string} cooking status
 */
export function cookingStatus (timer) {
  let result
  if (timer === 0) {
    result = 'Lasagna is done.'
  } else if (timer > 0) {
    result = 'Not done, please wait.'
  } else {
    result = 'You forgot to set the timer.'
  }
  return result
}

/**
 * Calculates preperation time for provided layers
 *
 * @param {string[]} layers
 * @param {number} layerPreparationTime (default 2)
 * @returns {number} total preparation time
 */
export function preparationTime (layers, layerPreparationTime = 2) {
  return layers?.length * layerPreparationTime
}

/**
 * Calculates quantities of sauce and noodles
 *
 * @param {string[]} layers
 * @returns {object} quantities of sauce and noodles
 */
export function quantities (layers) {
  const result = {
    noodles: 0,
    sauce: 0
  }
  for (const layer of layers) {
    switch (layer) {
      case 'noodles':
        result.noodles += 50
        break
      case 'sauce':
        result.sauce += 0.2
        break
    }
  }
  return result
}

/**
 *  Adds secret ingredient
 *
 *  @param {string[]} friendsIngredients
 *  @param {string[]} yoursIngredients
 *  @returns {undefined} (modifies passed yoursIngredients array)
 */
export function addSecretIngredient (friendsIngredients, yourIngredients) {
  const secretIngredient = friendsIngredients[friendsIngredients.length - 1]
  yourIngredients.push(secretIngredient)
}

/**
 * Scales recipe for more portions
 *
 * @param {object} recipe
 * @param {number} numberOfPortions
 * @returns {object} scaled recipe
 */
export function scaleRecipe (recipe, numberOfPortions) {
  const scale = numberOfPortions / 2
  const result = {}
  for (const ingredient in recipe) {
    result[ingredient] = recipe[ingredient] * scale
  }
  return result
}
