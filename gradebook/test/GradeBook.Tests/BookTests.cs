using System;
using Xunit;


namespace GradeBook.Tests
{

    public class BookTests
    {
        [Fact]
        public void BookCalculatesAnAverageGrade()
        {
            var book = new GradeBook.Book();
            book.AddGrade(2.2);
            book.AddGrade(3.2);

            var result = book.getStatistics();
            Assert.Equal(2.7, result.Average);
            Assert.Equal(3.2, result.High);
            Assert.Equal(2.2, result.Low);

        }
    }
}