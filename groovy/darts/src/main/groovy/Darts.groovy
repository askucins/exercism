class Darts {

    static ranges = [
            [dim: 1, pts: 10],
            [dim: 5, pts: 5],
            [dim: 10, pts: 1],
    ]

    static boolean inside(dim, x, y) {
        x * x + y * y <= dim * dim
    }

    static int score(x, y) {
        def target = ranges.find { rng -> inside(rng.dim, x, y) }
        target ? target.pts : 0
    }
}