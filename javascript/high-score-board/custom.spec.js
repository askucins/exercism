import {updateScore,} from './high-score-board';

describe('updateScore', () => {
    test("skips increasing a not registered player's score", () => {
        const scoreBoard = {
            'Amil Pastorius': 99373,
            'Min-seo Shin': 0,
            'Jesse Johnson': 1337,
        };

        const expected = {
            'Amil Pastorius': 99373,
            'Min-seo Shin': 0,
            'Jesse Johnson': 1337,
        };

        const actual = updateScore(scoreBoard, 'Ala Makota', 13);
        expect(actual).toEqual(expected);

        // This checks that the same object that was passed in is returned.
        expect(Object.is(actual, scoreBoard)).toBe(true);
    });
});