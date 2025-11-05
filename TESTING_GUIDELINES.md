# Testing Guidelines

This document outlines the testing standards and conventions for the Connect4 project.

## Assertion Style

**RULE: Always use Hamcrest `assertThat` syntax for assertions in tests.**

### Why assertThat?

- **Readability**: `assertThat(actual, is(expected))` reads more naturally than `assertEquals(expected, actual)`
- **Consistency**: Provides a uniform assertion style across all tests
- **Better error messages**: Hamcrest matchers provide clearer failure messages
- **Extensibility**: Easy to add custom matchers for domain-specific assertions

### Required Imports

```java
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
```

### Correct Usage

✅ **DO:**
```java
assertThat(column.hasTokenAt(0), is(true));
assertThat(column.hasTokenAt(2), is(false));
assertThat(column.placeToken(), is(true));
assertThat(game.hasWinner(Colour.Red), is(false));
```

❌ **DON'T:**
```java
assertTrue(column.hasTokenAt(0));
assertFalse(column.hasTokenAt(2));
assertEquals(true, column.placeToken());
```

### Exception for Exception Testing

For testing exceptions, use JUnit 5's `assertThrows()` as Hamcrest doesn't provide a better alternative:

```java
import static org.junit.jupiter.api.Assertions.assertThrows;

assertThrows(IndexOutOfBoundsException.class, () -> {
    board.placeTokenAt(8);
});
```

## Dependencies

The project includes Hamcrest 2.2 for assertions:

```gradle
testImplementation 'org.hamcrest:hamcrest:2.2'
```

## Test Framework

- **Test Framework**: JUnit 5 (Jupiter)
- **Assertion Library**: Hamcrest
- **Setup Method**: Use `@BeforeEach` for test setup

## When Creating/Modifying Tests

1. **Always** use `assertThat` with Hamcrest matchers
2. Follow existing test naming conventions: `when_X_then_Y` format
3. Keep tests focused on a single behavior
4. Use descriptive test method names
5. Ensure all tests pass before committing

---

**This is a project convention that must be followed by all contributors, including AI assistants.**
