package com.example.espressouicodingwithmitch.ui

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MovieListFragmentTest::class,
    DirectorsFragmentTest::class,
    StarActorsFragmentTest::class,
    MovieDetailFragmentTest::class
)
class MovieFragmentTestSuite