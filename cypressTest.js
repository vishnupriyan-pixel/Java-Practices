class cypressTest
{
  visit1()
  {
    cy.visit("https://jqueryui.com/autocomplete/")
  }
  visit2()
  {
    cy.visit("https://jqueryui.com/button/")
  }
  visit3()
  {
    cy.visit("https://jqueryui.com/checkboxradio/")
  }

  visit4()
  {
    cy.visit("https://jqueryui.com/controlgroup/")
  }

  visit5()
  {
    cy.visit("https://jqueryui.com/datepicker/")
  }

  visit6()
  {
    cy.visit("https://jqueryui.com/dialog/")
  }

  visit7()
  {
    cy.visit("https://jqueryui.com/menu/")
  }

  visit8()
  {
    cy.visit("https://jqueryui.com/progressbar/")
  }

  visit9()
  {
    cy.visit("https://jqueryui.com/selectmenu/")
  }
  chck_iframe()
  {

    // const $body = $iframe.contents().find('body')
    const check = cy.get('.demo-frame')

  }


}

export default cypressTest

