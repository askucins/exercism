class SpaceAge {

    static EarthOrbitalPeriodInSecond = 31557600.0
    static OrbitalPeriod = [
            Earth  : 1.0, //365.25 days, 31557600 seconds
            Mercury: 0.2408467,
            Venus  : 0.61519726,
            Mars   : 1.8808158,
            Jupiter: 11.862615,
            Saturn : 29.447498,
            Uranus : 84.016846,
            Neptune: 164.79132,
    ]

    static ReciprocalEarthOrbitalPeriodInSecond = 1.0 / 31557600.0
    static ReciprocalOrbitalPeriod = [
            Earth  : 1.0,
            Mercury: 1.0 / 0.2408467,
            Venus  : 1.0 / 0.61519726,
            Mars   : 1.0 / 1.8808158,
            Jupiter: 1.0 / 11.862615,
            Saturn : 1.0 / 29.447498,
            Uranus : 1.0 / 84.016846,
            Neptune: 1.0 / 164.79132,
    ]

    static double age(String planet, int seconds) {
        (seconds.toDouble() / EarthOrbitalPeriodInSecond / OrbitalPeriod[(planet)]).round(2)
        //(seconds.toDouble() * ReciprocalEarthOrbitalPeriodInSecond / orbitalPeriod[(planet)]).round(2)
        //(seconds.toDouble() * ReciprocalEarthOrbitalPeriodInSecond * ReciprocalOrbitalPeriod[(planet)]).round(2)
    }
}