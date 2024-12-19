# Navigation system template

System requirements:
- Own back stack for each tab
Implemented via own NavHost for each tab.
Options: implement own navigation library or wait for support, going with five hosts.

- Same screen may appear in multiple back stacks with different state
Navigation system introduces Destination class, which contains minimum set of data, which is required
to launch/restore any screen. When user switches between tabs, state of such screens will be restored
based on Destination data.

- Back stack state should save its' state upon tab switch or configuration change
Navigation library uses serialization to make backstack entries survive configuration changes. Tab
switch implemented via switching controllers.

Issue: Scroll state resets upon tab switch.

Solution: Scroll state should be handled manually.

Options:
    1) ~~Handle on presentation layer via Destination.~~ Navigation library backstack cannot be affected
    2) Handle on UI layer via global scroll state holder.

- Same screen may have multiple representations (full screen, bottom sheet, dialog)

Issue: each representation, which is not full screen, makes two screens visible at once. Navigation
library does not support this, unless it's a dialog. Alternative solution - direct injection of
destinations into each other - makes navigation hard to debug and support, since at this point we
may receive internal navigation flows (show diagram).

Solution: keep such representations as screen-specific components instead of making them destinations.
Options:
    1) Show screen-specific components based on screen state.
    2) Since navigation library supports dialog, those still can be navigation destinations.
    In this case we have overhead: each will have own destination. Also those are not actually
    destinations, as those won't be saved in backstack.

Solution: ~~support custom implementation, which supports displaying two destinations at once.~~
Rejection reason: this requires implementation of own backstack, at this point usage of library
makes no sense.

- Navigation events should always pass through presentation layer
Solution: Singleton, which allows multiple destination producers, but only one consumer. Being injected
in ViewModel of each screen, it allows to send destinations from anywhere and being received by global
navigation handler.
Singleton will be represented via interface and will allow different implementations. This will help
to change/update implementations and test navigation.

- Navigation system should be easily expandable and easy to use and understand
Solution:
Each screen-level composable should be shown based on Destination data.
Each screen-level composable should be used in code only once (exception - same screen in different
NavHosts)
Each screen can be switched only by sending Destination of target screen to the DestinationChannel.
Tabs can be switched only by sending Destination of target Backstack to the DestinationChannel.
Application-level composable consumes each sent Destination and proxies it to the NavControllers.

- Navigation system should support deeplinks

Solution: ~~navigation library feature~~
Rejection reason: it does not support backstacks and in case of weird deeplink format ("/bonusbox")
will require additional handling in scope of specific screen. Each backstack will need own handling
for same screen.

Solution:
Deeplink to List<Destination> converter. Keeps all deeplink logic isolated and easy to test. That
makes navigation flow completely independent from deeplink logic.

- Navigation system should support animation edge cases
Solution: Each destination show support both application-level and screen-level components (in most
cases it will be bottom bar, but cases with top bar are also possible).