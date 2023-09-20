#include "make_big_number.h"

#include <gtest/gtest.h>

GTEST_TEST(MakeBigNumber, RemoveTwoNumbers)
{
    EXPECT_EQ(MakeBigNumber("1924", 2), "94");
}

GTEST_TEST(MakeBigNumber, RemoveThreeNumbers)
{
    EXPECT_EQ(MakeBigNumber("1231234", 3), "3234");
}

GTEST_TEST(MakeBigNumber, RemoveFourNumbers)
{
    EXPECT_EQ(MakeBigNumber("4177252841", 4), "775841");
}
